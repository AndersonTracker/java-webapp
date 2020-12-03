package com.sorveteria.servlets;

public interface DefaultServlet {
    void doGet(int id);
    void doGetAll();
	void doPost();
	void doPut(int id);
	void doDelete(int id);
}
