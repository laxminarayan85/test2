package com.efi.printsmith.service.repository;  
  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
  
import java.nio.ByteBuffer;  
import java.nio.channels.FileChannel;  
  
import java.util.ArrayList;  
import java.util.Date;
import java.util.List;  

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.efi.printsmith.service.DataService;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;
  
public class ReportRepository extends HibernateService {  
  
  
   public String  doUpload(byte[] bytes, String fileName) throws Exception  
   {  
       fileName = System.getProperty("java.io.tmpdir") + "/" + fileName;  
       File f = new File(fileName);  
       FileOutputStream fos = new FileOutputStream(f);  
       fos.write(bytes);  
       fos.close();  
       return "success";  
   }  
  
   public List  getDownloadList()  
   {  
       File dir = new File(System.getProperty("java.io.tmpdir"));  
       String[] children = dir.list();  
       List dirList = new ArrayList();  
       if (children == null) {  
              // Either dir does not exist or is not a directory  
          } else {  
              for (int i=0; i<children.length; i++) {  
                  // Get filename of file or directory  
                  dirList.add( children[i]);  
              }  
          }  
       return dirList;  
   }  
  
   public String doDownload(String fileName)  
   {  
       FileInputStream fis;  
       byte[] data =null;  
       FileChannel fc;  
  
       try {  
           fis = new FileInputStream(System.getProperty("java.io.tmpdir") + "/" + fileName);  
           fc = fis.getChannel();  
           data = new byte[(int)(fc.size())];  
           ByteBuffer bb = ByteBuffer.wrap(data);  
           fc.read(bb);  
       } catch (FileNotFoundException e) {  
           // TODO  
       } catch (IOException e) {  
           // TODO  
       }  
//       return data;
       return "hello";
   }  
	public Object load(Class clazz, long id)
	{
       Session session = null;
       Object result;

       try
       {
           session = DataService.getSession();
           long tStart = new Date().getTime();
           result = session.get(clazz, id);
           long tEnd = new Date().getTime();
     //      log.debug("{load()}" +(tEnd-tStart) +"ms  class=" +clazz.getName() );
           
       }
       catch (HibernateException ex)
       {
           HibernateUtil.rollbackTransaction();
           ex.printStackTrace();
           throw ex;
       }
       catch (RuntimeException ex)
       {
           HibernateUtil.rollbackTransaction();
           ex.printStackTrace();
           throw ex;
       } finally {
    	   session.close();
       }

       return result;
	}
}  