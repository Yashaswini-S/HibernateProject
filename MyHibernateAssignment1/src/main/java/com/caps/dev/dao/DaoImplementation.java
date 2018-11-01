package com.caps.dev.dao;

import com.caps.dev.beans.PersonDetails;

public interface DaoImplementation {
	public void create(PersonDetails persondetails);
	public void update(PersonDetails persondetails);
	public void delete(PersonDetails persondetails);
	public void search(PersonDetails persondetails);
}
