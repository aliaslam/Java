
public class TeamStats {

	int totalThrows, totalOuts, totalCatches, totalDodges;
	String name;

		
	public TeamStats(String name){
		this.name = name;
		totalThrows = 0;
		totalOuts = 0;
		totalCatches = 0;
		totalDodges = 0;		
	}
	
	public void addThrow() {
		this.totalThrows ++;
	}
	
	public void addOut(){
		this.totalOuts++;
	}
	
	public void addCatch(){
		this.totalCatches++;
	}
	
	public void addDodge(){
		this.totalDodges++;
	}	
	
	public int getTotalThrows() {
		return totalThrows;
	}

	public void setTotalThrows(int totalThrows) {
		this.totalThrows = totalThrows;
	}

	public int getTotalOuts() {
		return totalOuts;
	}

	public void setTotalOuts(int totalOuts) {
		this.totalOuts = totalOuts;
	}

	public int getTotalCatches() {
		return totalCatches;
	}

	public void setTotalCatches(int totalCatches) {
		this.totalCatches = totalCatches;
	}

	public int getTotalDodges() {
		return totalDodges;
	}

	public void setTotalDodges(int totalDodges) {
		this.totalDodges = totalDodges;
	}
	
	public void printStats(){
		System.out.println(totalDodges);
	}
	
}
