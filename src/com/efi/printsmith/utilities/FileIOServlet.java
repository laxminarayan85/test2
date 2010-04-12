package com.efi.printsmith.utilities;



	import java.io.File;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.List;
	 
	import javax.servlet.Servlet;
	import javax.servlet.ServletException;

	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	 
	import org.apache.commons.fileupload.FileItem;
	import org.apache.commons.fileupload.FileItemFactory;
	import org.apache.commons.fileupload.disk.DiskFileItemFactory;
	import org.apache.commons.fileupload.servlet.ServletFileUpload;
	import org.apache.log4j.Logger;

	public class FileIOServlet extends HttpServlet implements Servlet {
		private static final long serialVersionUID = 1L;
		private File tmpDir;

		protected static Logger log = Logger.getLogger(FileIOServlet.class);
	 
		public void init() throws ServletException {
		}
	 
		@SuppressWarnings("unchecked")
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String realPath = request.getSession().getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"upload"+File.separator;
	 
			DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
			/*
			 *Set the size threshold, above which content will be stored on disk.
			 */
			fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
			/*
			 * Set the temporary directory to store the uploaded files of size above threshold.
			 */
			fileItemFactory.setRepository(tmpDir);
	 
			try {
				/*
				 * Parse the request
				 */
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					/*
					 * Handle Form Fields.
					 */
					if(item.isFormField()) {
					} else {
						//Handle Uploaded files.
						File file = new File(realPath,item.getName());
						if (!file.exists()){
							item.write(file);
						}else{
							throw new IOException("File already exists.");
						}
					}
				}
			}catch(IOException ex) {
				log.error(ex);
				throw ex;
			} catch(Exception ex) {
				log.error(ex);
			}
	 
		}
	 
	}