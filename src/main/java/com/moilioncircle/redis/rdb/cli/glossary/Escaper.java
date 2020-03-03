/*
 * Copyright 2016-2017 Leon Chen
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

package com.moilioncircle.redis.rdb.cli.glossary;

import java.io.OutputStream;

import com.moilioncircle.redis.rdb.cli.conf.Configure;

/**
 * @author Baoyi Chen
 */
public interface Escaper {

    default void encode(byte[] bytes, OutputStream out, Configure configure) {
        encode(bytes, 0, bytes.length, out, configure);
    }

    default void encode(long value, OutputStream out, Configure configure) {
        encode(String.valueOf(value).getBytes(), out, configure);
    }

    default void encode(double value, OutputStream out, Configure configure) {
        encode(String.valueOf(value).getBytes(), out, configure);
    }

    //
    void encode(int b, OutputStream out, Configure configure);

    void encode(byte[] bytes, int off, int len, OutputStream out, Configure configure);
}
