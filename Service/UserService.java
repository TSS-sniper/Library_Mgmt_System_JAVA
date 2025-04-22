package src.Service;

import src.Entity.User;

public class UserService implements User {
    private String name;
    private String userId;
    private int borrowedBookCount;

    public UserService(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBookCount = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public int getBorrowedBookCount() {
        return borrowedBookCount;
    }

    @Override
    public void borrowBook() {
        borrowedBookCount++;
    }

    @Override
    public void returnBook() {
        if (borrowedBookCount > 0) borrowedBookCount--;
    }
}

