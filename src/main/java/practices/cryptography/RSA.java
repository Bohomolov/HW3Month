package practices.cryptography;

import java.math.BigInteger;

public class RSA {
    private final int firstPrime = 3;
    private final int secondPrime = 104561;
    private final int exponent = getExponent();
    private final int module = getModule();
    private final int eilert = getEilert();
    private int exponentPK;
    private final int[] publicKey = generateKey(exponent, module);
    private final int[] privatKey = generateKey(exponentPK, module);

    public int[] getPublicKey() {
        return publicKey;
    }

    public int getDecode(int number) {
        generateExponentForPrivateKey();
        BigInteger mod = BigInteger.valueOf(privatKey[1]);
        BigInteger c = BigInteger.valueOf(encodeInt(number));
        BigInteger messageBack = (c.pow(exponentPK)).mod(mod);
        return messageBack.intValue();
    }

    private int encodeInt(int openNumber) {
        return (int) Math.pow(openNumber, publicKey[0]) % module;
    }

    private int[] generateKey(int exponent, int module) {
        int[] key = new int[2];
        key[0] = exponent;
        key[1] = module;
        return key;
    }

    private void generateExponentForPrivateKey() {
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * eilert);

            if (x % exponent == 0) {
                exponentPK = x / exponent;
                break;
            }
        }
    }

    private int getExponent() {
        int eilert = getEilert();
        int exponent;
        for (exponent = 2; exponent < eilert; exponent++) {
            if (exponentCheck(exponent, eilert) == 1) {
                return exponent;
            }
        }
        return exponent;
    }

    private int exponentCheck(int exponent, int eilert) {
        if (exponent == 0) {
            return eilert;
        } else {
            return exponentCheck(eilert % exponent, exponent);
        }
    }


    private int getEilert() {
        return (firstPrime - 1) * (secondPrime - 1);
    }

    private int getModule() {
        return firstPrime * secondPrime;
    }

//    private int generatePrime() {
//        Random random = new Random();
//        int randomNumber;
//        do {
//            randomNumber = random.nextInt(8) + 2;
//        } while (!checkNumberIsPrime(randomNumber));
//        return randomNumber;
//    }

    private boolean checkNumberIsPrime(int number) {
        if (number < 2) {
            return false;
        }
        int i;
        for (i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
