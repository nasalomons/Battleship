package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import battlefield.Battlefield;
import battlefield.Coordinates;

public class BattlefieldTests {

	@Test
	public void testPlaceTugboat() {
		Battlefield battlefield = new Battlefield();
		Coordinates start = new Coordinates(2, 3);
		Coordinates endOne = new Coordinates(2, 4);
		Coordinates endTwo = new Coordinates(1, 3);
		Coordinates bad = new Coordinates(6, 6);
		battlefield.setTugboat(1, start, endOne);
		battlefield.setTugboat(2, start, endTwo);
		try {
			battlefield.setTugboat(1, start, endTwo);
		} catch(RuntimeException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSinkTugboat() {
		Battlefield battlefield = new Battlefield();
		Coordinates start = new Coordinates(2, 3);
		Coordinates end = new Coordinates(2, 4);
		battlefield.setTugboat(1, start, end);
		battlefield.getShip(1, start).beHit();
		battlefield.sinkShip(1, start);
		battlefield.getShip(1, end).beHit();
		battlefield.sinkShip(1, start);
	}
	
	@Test
	public void testPlaceFightShip() {
		Battlefield battlefield = new Battlefield();
		Coordinates start = new Coordinates(2, 3);
		Coordinates endOne = new Coordinates(2, 5);
		Coordinates endTwo = new Coordinates(0, 3);
		Coordinates badOne = new Coordinates(1, 4);
		Coordinates badTwo = new Coordinates(3, 4);
		try {
			battlefield.setFightship(1, start, endOne);
			battlefield.setFightship(2, endTwo, start);
			battlefield.setFightship(1, badOne, badTwo);
			assertTrue(false);
		} catch(RuntimeException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSinkFightship() {
		Battlefield battlefield = new Battlefield();
		Coordinates start = new Coordinates(2, 3);
		Coordinates end = new Coordinates(2, 5);
		battlefield.setFightship(1, start, end);
		for(int i = start.getCol(); i<=end.getCol(); i++) {
			battlefield.getShip(1, new Coordinates(start.getRow(), i)).beHit();
			battlefield.sinkShip(1, new Coordinates(start.getRow(), i));
		}
		int i;
	}
	
	@Test
	public void testPlaceSubmarine() {
		Battlefield battlefield = new Battlefield();
		Coordinates start = new Coordinates(4, 3);
		Coordinates endOne = new Coordinates(4, 6);
		Coordinates endTwo = new Coordinates(7, 3);
		Coordinates badOne = new Coordinates(5, 4);
		Coordinates badTwo = new Coordinates(5, 7);
		try {
			battlefield.setSubmarine(1, start, endOne);
			battlefield.setSubmarine(2, start, endTwo);
			battlefield.setSubmarine(1, badOne, badTwo);
			assertTrue(false);
		} catch(RuntimeException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSinkSubmarine() {
		Battlefield battlefield = new Battlefield();
		Coordinates start = new Coordinates(2, 3);
		Coordinates end = new Coordinates(2, 6);
		battlefield.setSubmarine(1, start, end);
		for(int i = start.getCol(); i<=end.getCol(); i++) {
			battlefield.getShip(1, new Coordinates(start.getRow(), i)).beHit();
			battlefield.sinkShip(1, new Coordinates(start.getRow(), i));
		}
	}
	
	@Test
	public void testPlaceAircraftCarrier() {
		Battlefield battlefield = new Battlefield();
		Coordinates start = new Coordinates(4, 3);
		Coordinates endOne = new Coordinates(4, 7);
		Coordinates endTwo = new Coordinates(8, 3);
		Coordinates badOne = new Coordinates(5, 4);
		Coordinates badTwo = new Coordinates(5, 8);
		try {
			battlefield.setAircraftCarrier(1, start, endOne);
			battlefield.setAircraftCarrier(2, start, endTwo);
			battlefield.setAircraftCarrier(1, badOne, badTwo);
			assertTrue(false);
		} catch(RuntimeException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSinkAircraftCarrier() {
		Battlefield battlefield = new Battlefield();
		Coordinates start = new Coordinates(2, 3);
		Coordinates end = new Coordinates(2, 7);
		battlefield.setAircraftCarrier(1, start, end);
		for(int i = start.getCol(); i<=end.getCol(); i++) {
			battlefield.getShip(1, new Coordinates(start.getRow(), i)).beHit();
			battlefield.sinkShip(1, new Coordinates(start.getRow(), i));
		}
	}
}
