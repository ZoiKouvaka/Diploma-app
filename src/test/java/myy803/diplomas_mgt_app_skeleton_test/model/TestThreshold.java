package myy803.diplomas_mgt_app_skeleton_test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.diplomas_mgt_app_skeleton.Threshold;

class TestThreshold {
	
	Threshold threshold;

	@BeforeEach
	void setUp() throws Exception {
		threshold = new Threshold();
	}

	@Test
	void testSetAndGetTh1() {
		threshold.setTh1(3.6);
		assertEquals(3.6, threshold.getTh1());
	}
	
	@Test
	void testSetAndGetTh2() {
		threshold.setTh2(3.7);
		assertEquals(3.7, threshold.getTh2());
	}

}