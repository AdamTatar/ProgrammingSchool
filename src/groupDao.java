import java.util.List;

public interface groupDao {

	
	Group insertGroup(Group group);
	Group updateGroup(Group group);
	boolean deleteGroup(Group group);

	List<Group> getAllGroups();
	Group getById(Group groupId);
	
	
}
