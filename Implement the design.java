import java.util.ArrayList;
import java.util.List;

public class Scrum {

    private List<BacklogItem> backlogItems;
    private List<Sprint> sprints;
    private List<TeamMember> teamMembers;
    private Sprint currentSprint;

    public Scrum() {
        backlogItems = new ArrayList<>();
        sprints = new ArrayList<>();
        teamMembers = new ArrayList<>();
    }

    public void addBacklogItem(BacklogItem item) {
        backlogItems.add(item);
    }

    public void removeBacklogItem(BacklogItem item) {
        backlogItems.remove(item);
    }

    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }

    public void addSprint(Sprint sprint) {
        sprints.add(sprint);
        currentSprint = sprint;
    }

    public void removeSprint(Sprint sprint) {
        sprints.remove(sprint);
        currentSprint = null;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void addTeamMember(TeamMember member) {
        teamMembers.add(member);
    }

    public void removeTeamMember(TeamMember member) {
        teamMembers.remove(member);
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public Sprint getCurrentSprint() {
        return currentSprint;
    }

    public static void main(String[] args) {
        Scrum scrum = new Scrum();
        BacklogItem item1 = new BacklogItem("Implement user authentication");
        BacklogItem item2 = new BacklogItem("Add support for multiple languages");
        scrum.addBacklogItem(item1);
        scrum.addBacklogItem(item2);
        TeamMember member1 = new TeamMember("John");
        TeamMember member2 = new TeamMember("Jane");
        scrum.addTeamMember(member1);
        scrum.addTeamMember(member2);
        Sprint sprint1 = new Sprint("Sprint 1");
        sprint1.addTask(new Task("Implement login page", member1));
        sprint1.addTask(new Task("Implement registration page", member2));
        scrum.addSprint(sprint1);
        System.out.println("Current sprint: " + scrum.getCurrentSprint().getName());
    }
}

class BacklogItem {
    private String description;

    public BacklogItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class Sprint {
    private String name;
    private List<Task> tasks;

    public Sprint(String name) {
        this.name = name;
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}

class Task {
    private String description;
    private TeamMember assignedTo;

    public Task(String description, TeamMember assignedTo) {
        this.description = description;
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public TeamMember getAssignedTo() {
        return assignedTo;
    }
}

class TeamMember {
    private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
