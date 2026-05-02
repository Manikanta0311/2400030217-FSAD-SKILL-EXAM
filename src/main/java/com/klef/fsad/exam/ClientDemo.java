package com.klef.fsad.exam;
//updated
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

public static void main(String[] args) {
	java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session session = sf.openSession();

Transaction tx = session.beginTransaction();

Inventory inv = new Inventory();
inv.setName("Laptop");
inv.setDescription("Dell Laptop");
inv.setDate(new Date());
inv.setStatus("Available");

session.save(inv);

tx.commit();

System.out.println("Record Inserted Successfully");

if(inv!=null)
{
session.delete(inv);
System.out.println("Record Deleted");
}
session.close();
sf.close();
}


}
