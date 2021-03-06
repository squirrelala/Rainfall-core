/*
 * Copyright 2014 Aurélien Broszniowski
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

package io.rainfall.generator;

import io.rainfall.SequenceGenerator;
import io.rainfall.generator.sequence.Distribution;
import io.rainfall.utils.ConcurrentPseudoRandom;

/**
 * @author Aurelien Broszniowski
 */
public class RandomSequenceGenerator implements SequenceGenerator {

  private final Distribution distribution;
  private final long minimum;
  private final long maximum;
  private final long width;
  private final ConcurrentPseudoRandom rnd = new ConcurrentPseudoRandom();

  public RandomSequenceGenerator(Distribution distribution, long min, long max, long width) {
    this.distribution = distribution;
    this.minimum = min;
    this.maximum = max;
    this.width = width;
  }

  @Override
  public long next() {
    return distribution.generate(rnd, minimum, maximum, width);
  }
}
