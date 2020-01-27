package FinalProject;


/**
 * 
 * 
 * File Name : FrameIteration.java
 * Author : Sean Hamilton
 * Date: 12/12/2019
 * Purpose of program: CMSC 412 UMUC Final Project. Helper class used to keep track of each frame iteration and display results to user.
 * 
 * 
 * 
 * 
 *
 */

class FrameIteration {
	int currNum;
	int lastIns;
	int timesCounter;
	int inserNum;
	int nextIns;
	

	FrameIteration(int n) {
		currNum = n;
		inserNum = -1;
		nextIns = -1;
		lastIns = -1;
		timesCounter = 0;
	}
	
	void setCurrNum(int n) {
		currNum = n;
	}
	int getCurrNum() {
		return currNum;
	}
	void setInserted(int n) {
		inserNum = n;
	}
	int getInserted() {
		return inserNum;
	}
	void setNextUse(int n) {
		nextIns = n;
	}
	int getNextUse() {
		return nextIns;
	}
	void setLastUse(int n) {
		lastIns = n;
	}
	int getLastUse() {
		return lastIns;
	}
	void incrementTimesUsed() {
		timesCounter += 1;
	}
	int getTimesUsed() {
		return timesCounter;
	}
}
