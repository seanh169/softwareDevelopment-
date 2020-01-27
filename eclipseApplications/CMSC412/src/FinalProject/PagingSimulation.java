package FinalProject;

import java.util.Scanner;

/**
 * 
 * 
 * File Name : PagingSimulation.java
 * Author : Sean Hamilton
 * Date: 12/12/2019
 * Purpose of program: CMSC 412 UMUC Final Project. Class that will implement logic for each paging algorithm if and when they are selected. 
 * 
 * 
 * 
 * 
 *
 */




class PagingSimulation {
	//All necessary variables, arrays, and matrices to perform each algorithm per requirements. 
	ReferenceInput referenceInput; 
	int[] removedPages; 
	int[] currentPageCalled; 
	boolean[] pageFaultArr;
	int referenceStringSize;
	int countPhysicalFrames;
	int countVirutalFrames;
	int[][] mainMemory; 
	FrameIteration[] currFrameArr;
	String algorithmChoice;

	//constructor
	PagingSimulation(ReferenceInput refs, int phys, int virt) {
		referenceInput = refs;
		referenceStringSize = referenceInput.getLength();
		removedPages = new int[referenceStringSize];
		currentPageCalled = new int[referenceStringSize];
		countPhysicalFrames = phys;
		countVirutalFrames = virt;
		mainMemory = new int[referenceInput.getLength()][phys];
		currFrameArr = new FrameIteration[virt];
		pageFaultArr = new boolean[referenceStringSize];
	}

	public void processSimulation(String inputAlg) {
		initialize();
		algorithmChoice = inputAlg;
		int currSlic = 0;
		int currFrameInse;
		int empty;
		int currFrameToReplace;
//		int[] curListOfFrames;
		int mainInMemory;
		while (currSlic < referenceStringSize) {
			currFrameInse = referenceInput.getAtIndex(currSlic);
			if (inputAlg == "LRU") {
				currFrameArr[currFrameInse].setLastUse(currSlic);
			} else if (inputAlg == "LFU") {
				currFrameArr[currFrameInse].incrementTimesUsed();
			}
			empty = findIndex(mainMemory[currSlic], -1);
			mainInMemory = findIndex(mainMemory[currSlic], currFrameInse);
			if (mainInMemory != -1) {
				currentPageCalled[currSlic] = mainInMemory;
				pageFaultArr[currSlic] = false;
			}
			else if (empty >= 0) {
				currentPageCalled[currSlic] = empty;
				mainMemory[currSlic][empty] = currFrameInse;
				currFrameArr[currFrameInse].setInserted(currSlic);
			}
			else {
				switch (inputAlg) {
					case "FIFO":
					currFrameToReplace = locateFirst(mainMemory[currSlic]);
					currFrameArr[currFrameInse].setInserted(currSlic);
					break;
					case "OPT":
					calculateNextUses(currSlic);
					currFrameToReplace = locateLOP(mainMemory[currSlic]);
					break;
					case "LFU":
					currFrameToReplace = locateLFU(mainMemory[currSlic]);
					break;
					case "LRU":
					currFrameToReplace = locateLRU(mainMemory[currSlic]);
					break;
					default:
					System.out.println("Error: algorithm not recognized!");
					return;
				}
				removedPages[currSlic] = mainMemory[currSlic][currFrameToReplace];
				currentPageCalled[currSlic] = currFrameToReplace;
				mainMemory[currSlic][currFrameToReplace] = currFrameInse;


			}
			if ((currSlic + 1) < referenceStringSize) {
				for (int i = 0; i < countPhysicalFrames; i ++) {
					mainMemory[currSlic +1][i] = mainMemory[currSlic][i];
				}
			}
			currSlic += 1;
		}
	}


	public int locateFirst(int[] inputArr) {
		int firstOld = currFrameArr[inputArr[0]].getInserted();
		int firstIdxLa = 0;
		int compareIdx;
		for (int i = 1; i < inputArr.length; i++) {
			compareIdx = currFrameArr[inputArr[i]].getInserted();
			if (compareIdx < firstOld) {
				firstOld = compareIdx;
				firstIdxLa = i;
			}
		}
		return firstIdxLa;
	}

	public int locateLFU(int[] inputArr) {
		int LFUidx = 0;
		int counterLFUidx = currFrameArr[inputArr[LFUidx]].getTimesUsed();

		for (int i = 1; i < inputArr.length; i++) {
			int temp = inputArr[i];
			int storagTimesUsed = currFrameArr[inputArr[i]].getTimesUsed();

			if (storagTimesUsed < counterLFUidx) {
				LFUidx = i;
				counterLFUidx = storagTimesUsed;
			}
		}

		return LFUidx;
	}

	public int locateLRU(int[] inputArr) {
		int LRUidx = 0;
		int LRUprev = currFrameArr[inputArr[LRUidx]].getLastUse();

		for (int i = 1; i < inputArr.length; i++) {
			int temp = inputArr[i];
			int LRULastUse = currFrameArr[inputArr[i]].getLastUse();

			if (LRULastUse < LRUprev) {
				LRUidx = i;
				LRUprev = LRULastUse;
			}
		}
		return LRUidx;
	}

	public int locateLOP(int[] inputArr) {
		int leastOptimal = inputArr[0];
		int leastOptimalIndex = 0;
		int leastOptNextUse = currFrameArr[leastOptimal].getNextUse();
		for (int i = 1; i < inputArr.length; i++) {
			int temp = inputArr[i];
			int tempNextUse = currFrameArr[temp].getNextUse();
			if (tempNextUse > leastOptNextUse) {
				leastOptimal = temp;
				leastOptNextUse = currFrameArr[leastOptimal].getNextUse();
				leastOptimalIndex = i;
			}
		}
		return leastOptimalIndex;
	}

	public void calculateNextUses(int n) {
		for (int i = 0; i < countVirutalFrames; i++) {
			currFrameArr[i].setNextUse(referenceStringSize + 1);
		}
		for (int i = referenceStringSize - 1; i >= n; i--) {
			int called = referenceInput.getAtIndex(i);
			currFrameArr[called].setNextUse(i);
		}
	}


	void initialize() {
		for (int i = 0; i < pageFaultArr.length; i++) {
			pageFaultArr[i] = true;
		}
		for (int i = 0; i < removedPages.length; i++) {
			removedPages[i] = -1;
		}
		for (int i = 0; i < currentPageCalled.length; i++) {
			currentPageCalled[i] = -1;
		}
		for (int i = 0; i < countVirutalFrames; i++) {
			currFrameArr[i] = new FrameIteration(i);
		}
		for (int i = 0; i < referenceStringSize; i++) {
			for (int j = 0; j < countPhysicalFrames; j ++) {
				mainMemory[i][j] = -1;
			}
		}
		algorithmChoice = "";
	}

	void print() {
		System.out.println("Algorithm: " + algorithmChoice);
		System.out.println("Length input: " + referenceStringSize);
		System.out.println("Virtual pages: " + countVirutalFrames);
		System.out.println("Physical pages: " + countPhysicalFrames);
		System.out.println("Press enter to move on to next part of simulation...");
		System.out.println("Press q to exit.");

		Scanner scannerDisplay = new Scanner(System.in);
		int currentIterSlc = 0;
		String userPrompt;
		int curFrameNum;
		int deletedInt;
		while (currentIterSlc < referenceStringSize) {
			userPrompt = scannerDisplay.nextLine();
			if (userPrompt.equals("q")) {
				System.out.println("You pressed q. Exiting to menu...");
				break;
			}
			System.out.println("Simulation " + (currentIterSlc + 1) + ":");
			System.out.println("Virtual frame number " + referenceInput.getAtIndex(currentIterSlc));
			for (int i = 0; i < countPhysicalFrames; i ++) {
				System.out.print("Physical frame " + i + ":");
				curFrameNum = mainMemory[currentIterSlc][i];
				if (curFrameNum >= 0) {
					if (i == currentPageCalled[currentIterSlc]) {
						System.out.println("[" + curFrameNum + "]");
					} else {
						System.out.println(" " + curFrameNum);
					}
				} else {
					System.out.println("x");
				}
			}
			deletedInt = removedPages[currentIterSlc];
			System.out.println("Page fault: " + (pageFaultArr[currentIterSlc] ? "True" : "False"));
			System.out.println("Victim frame #: " + (deletedInt == -1 ? "None." : deletedInt));
			currentIterSlc += 1;
		}
		System.out.print("Completed. Press enter to continue.");
		scannerDisplay.nextLine();
	}

	int findIndex(int[] inputArr, int n) {
		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i] == n) {
				return i;
			}
		}
		return -1;
	}
}

