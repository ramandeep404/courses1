<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
</head>
<body>


<html:form action="Upload" method="post" enctype="multipart/form-data">
     User Name :<html:text name="FileUploadForm" name="username" />
<br />
	 <html:file property="file" size="50" />
<br />
<br />
<html:submit value='Submit'/>
</html:form>


</body>
</html>