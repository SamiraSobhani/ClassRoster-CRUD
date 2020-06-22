package com.ClassRoster.ClassRoster.ClassRosterDAO;

public interface ClassRosterAuditDao {

    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
}
