import java.util.List;

public interface SolutionDao {


	Solution insertSolution(Solution solution);
	Solution updateSolution(Solution solution);
	boolean deleteSolution(Solution solution);

	List<Solution> getAllStudents();
	Solution getById(Integer solutionId);
	
}
