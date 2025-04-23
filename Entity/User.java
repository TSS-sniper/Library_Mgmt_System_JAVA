package extra.Library_Management_System.Entity;

import java.util.*;

public class User {
    public String userName;
    public String userId;
    private List<String> issueHistory = new ArrayList<>();

    public void addIssue(String entry) {
        issueHistory.add(entry);
    }

    public List<String> getIssueHistory() {
        return issueHistory;
    }}