/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package libcore.javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.DSAParameterSpec;
import tests.security.AlgorithmParameterSignatureHelper;
import tests.security.AlgorithmParametersTest;

public class AlgorithmParametersTestDSA extends AlgorithmParametersTest {

    /*
     * Parameters generated with OpenSSL:
     * openssl dsaparam -genkey 1024 -C
     */
    private static final byte[] P = new byte[] {
            (byte) 0xE6, (byte) 0x41, (byte) 0x58, (byte) 0x77, (byte) 0x76,
            (byte) 0x5A, (byte) 0x4A, (byte) 0x53, (byte) 0xF1, (byte) 0xD6,
            (byte) 0xC8, (byte) 0x7D, (byte) 0x67, (byte) 0x1F, (byte) 0x2F,
            (byte) 0xFA, (byte) 0xDE, (byte) 0xB7, (byte) 0xAA, (byte) 0xCD,
            (byte) 0xD7, (byte) 0x5D, (byte) 0xD0, (byte) 0xE9, (byte) 0xB1,
            (byte) 0xDA, (byte) 0xFE, (byte) 0x42, (byte) 0xBE, (byte) 0xCC,
            (byte) 0x42, (byte) 0x52, (byte) 0x2E, (byte) 0x01, (byte) 0xD2,
            (byte) 0x16, (byte) 0xB1, (byte) 0x5B, (byte) 0xC4, (byte) 0x42,
            (byte) 0xF9, (byte) 0x55, (byte) 0x0F, (byte) 0xE2, (byte) 0xD5,
            (byte) 0x01, (byte) 0xD2, (byte) 0x7E, (byte) 0x22, (byte) 0xF6,
            (byte) 0xC1, (byte) 0xFE, (byte) 0x5C, (byte) 0x6A, (byte) 0xCF,
            (byte) 0x82, (byte) 0x1B, (byte) 0x5C, (byte) 0x46, (byte) 0x66,
            (byte) 0x8B, (byte) 0xAF, (byte) 0xDF, (byte) 0x44, (byte) 0xE2,
            (byte) 0x0E, (byte) 0xA3, (byte) 0x58, (byte) 0xF7, (byte) 0xA3,
            (byte) 0x24, (byte) 0xE3, (byte) 0x84, (byte) 0xA6, (byte) 0x16,
            (byte) 0xE0, (byte) 0xCA, (byte) 0x72, (byte) 0x55, (byte) 0x07,
            (byte) 0xA0, (byte) 0x99, (byte) 0x7B, (byte) 0xF8, (byte) 0xB1,
            (byte) 0x5A, (byte) 0x84, (byte) 0x36, (byte) 0x5A, (byte) 0xC8,
            (byte) 0x6A, (byte) 0xFE, (byte) 0xA6, (byte) 0xB4, (byte) 0x1B,
            (byte) 0x3A, (byte) 0x0A, (byte) 0x00, (byte) 0x6B, (byte) 0x72,
            (byte) 0xDC, (byte) 0x0C, (byte) 0xD1, (byte) 0x09, (byte) 0x25,
            (byte) 0x11, (byte) 0x68, (byte) 0x6B, (byte) 0x75, (byte) 0xDE,
            (byte) 0x2C, (byte) 0x1A, (byte) 0xC2, (byte) 0x3A, (byte) 0xCB,
            (byte) 0xA0, (byte) 0x17, (byte) 0xCA, (byte) 0x2D, (byte) 0xEE,
            (byte) 0xA2, (byte) 0x5A, (byte) 0x9D, (byte) 0x1F, (byte) 0x33,
            (byte) 0x1B, (byte) 0x07, (byte) 0x6D,
    };
    private static final byte[] Q = new byte[] {
            (byte) 0x9B, (byte) 0x39, (byte) 0xD0, (byte) 0x02, (byte) 0x0F,
            (byte) 0xE9, (byte) 0x96, (byte) 0x16, (byte) 0xC5, (byte) 0x25,
            (byte) 0xF7, (byte) 0x94, (byte) 0xA9, (byte) 0x2C, (byte) 0xD0,
            (byte) 0x25, (byte) 0x5B, (byte) 0x6E, (byte) 0xE0, (byte) 0x8F,
    };
    private static final byte[] G = new byte[] {
            (byte) 0x5E, (byte) 0x9C, (byte) 0x95, (byte) 0x5F, (byte) 0x7E,
            (byte) 0x91, (byte) 0x47, (byte) 0x4D, (byte) 0x68, (byte) 0xA4,
            (byte) 0x1C, (byte) 0x44, (byte) 0x3B, (byte) 0xEC, (byte) 0x0A,
            (byte) 0x7E, (byte) 0x59, (byte) 0x54, (byte) 0xF7, (byte) 0xEF,
            (byte) 0x42, (byte) 0xFB, (byte) 0x63, (byte) 0x95, (byte) 0x08,
            (byte) 0x2F, (byte) 0x4A, (byte) 0xD3, (byte) 0xBC, (byte) 0x79,
            (byte) 0x9D, (byte) 0xBA, (byte) 0xD8, (byte) 0x8A, (byte) 0x83,
            (byte) 0x84, (byte) 0xAE, (byte) 0x5B, (byte) 0x26, (byte) 0x80,
            (byte) 0xB3, (byte) 0xFB, (byte) 0x9C, (byte) 0xA3, (byte) 0xCF,
            (byte) 0xF4, (byte) 0x0A, (byte) 0xD5, (byte) 0xB6, (byte) 0x65,
            (byte) 0x65, (byte) 0x1A, (byte) 0x4F, (byte) 0xC0, (byte) 0x86,
            (byte) 0x3B, (byte) 0xE6, (byte) 0xFB, (byte) 0x4E, (byte) 0x9E,
            (byte) 0x49, (byte) 0x0A, (byte) 0x8C, (byte) 0x77, (byte) 0x2D,
            (byte) 0x93, (byte) 0x0B, (byte) 0xCA, (byte) 0x81, (byte) 0x07,
            (byte) 0x09, (byte) 0xC4, (byte) 0x71, (byte) 0xFD, (byte) 0xC8,
            (byte) 0xC7, (byte) 0xD1, (byte) 0xA3, (byte) 0xD0, (byte) 0xBB,
            (byte) 0x7D, (byte) 0x92, (byte) 0x74, (byte) 0x8B, (byte) 0x3B,
            (byte) 0x2A, (byte) 0x45, (byte) 0x1F, (byte) 0x5D, (byte) 0x85,
            (byte) 0x90, (byte) 0xE3, (byte) 0xFB, (byte) 0x0E, (byte) 0x16,
            (byte) 0xBA, (byte) 0x8A, (byte) 0xDE, (byte) 0x10, (byte) 0x0F,
            (byte) 0xE0, (byte) 0x0F, (byte) 0x37, (byte) 0xA7, (byte) 0xC1,
            (byte) 0xDC, (byte) 0xBC, (byte) 0x00, (byte) 0xB8, (byte) 0x24,
            (byte) 0x0F, (byte) 0xF6, (byte) 0x5F, (byte) 0xB1, (byte) 0xA8,
            (byte) 0x9A, (byte) 0xDB, (byte) 0x9F, (byte) 0x36, (byte) 0x54,
            (byte) 0x45, (byte) 0xBD, (byte) 0xC0, (byte) 0xE8, (byte) 0x27,
            (byte) 0x82, (byte) 0xC9, (byte) 0x75,
    };


    public AlgorithmParametersTestDSA() {
        super("DSA", new AlgorithmParameterSignatureHelper<DSAParameterSpec>(
                "DSA", DSAParameterSpec.class), new DSAParameterSpec(
                new BigInteger(1, P), new BigInteger(1, Q), new BigInteger(1, G)));
    }

}
