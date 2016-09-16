/*
 * Copyright (C) 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package benchmarks.regression;

import java.net.IDN;

public class IdnBenchmark {

    public void timeToUnicode(int reps) {
        for (int i = 0; i < reps; i++) {
            IDN.toASCII("fass.de");
            IDN.toASCII("faß.de");
            IDN.toASCII("fäß.de");
            IDN.toASCII("a\u200Cb");
            IDN.toASCII("öbb.at");
            IDN.toASCII("abc・日本.co.jp");
            IDN.toASCII("日本.co.jp");
            IDN.toASCII("x\u0327\u0301.de");
            IDN.toASCII("σόλοσ.gr");
        }
    }

    public void timeToAscii(int reps) {
        for (int i = 0; i < reps; i++) {
            IDN.toUnicode("xn--fss-qla.de");
            IDN.toUnicode("xn--n00d.com");
            IDN.toUnicode("xn--bb-eka.at");
            IDN.toUnicode("xn--og-09a.de");
            IDN.toUnicode("xn--53h.de");
            IDN.toUnicode("xn--iny-zx5a.de");
            IDN.toUnicode("xn--abc-rs4b422ycvb.co.jp");
            IDN.toUnicode("xn--wgv71a.co.jp");
            IDN.toUnicode("xn--x-xbb7i.de");
            IDN.toUnicode("xn--wxaikc6b.gr");
            IDN.toUnicode("xn--wxaikc6b.xn--gr-gtd9a1b0g.de");
        }
    }

}
