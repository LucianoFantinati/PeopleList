package com.mercadolibre.people_list_group_6.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.people_list_group_6.beans.RandomSampleBean;
import com.mercadolibre.people_list_group_6.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
