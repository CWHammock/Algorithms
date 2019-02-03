package com.warren.schedulegreedy;

public class Jobs implements Comparable<Jobs>{
	
	private int startTime;
	private int endTime;
	
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public Jobs(int startTime, int endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		String output = ("startTime: " + this.startTime + " endtime: " + this.endTime + "\n");
		return output;
	}

	@Override
	public int compareTo(Jobs otherJobs) {
		if (this.endTime < otherJobs.endTime) return -1;
		else if (this.endTime > otherJobs.endTime) return 1;
		else return 0;
	}
	
	
}
