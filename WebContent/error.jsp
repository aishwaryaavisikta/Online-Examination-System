<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function submitbookdata() {
    var bookidArr = [];
    var bookpriceArr = [];
    $('.book').each(function() {
        if ($(this).is(':checked')) {// check the checked property with .is
               var current = $(this).val();
               bookpriceArr.push($(this).parents("tr").find(".bookprice").val()) //get the input textbox associated with it
        }
        bookidArr.push($(this).val());
    });
    alert(bookpriceArr);
}
</script>
</head>
<body>
<table>
<tr>
<th>COLUMN 1</th>
<th>COLUMN 2</th>
<th>COLUMN 3</th>
</tr>
<tr>
<td><input type="checkbox" name="book" class="book" value="Checkbox 1"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="200"/></td>
<td><input type="checkbox" name="book" class="book" value="Checkbox 2"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="200"/></td>
<td><input type="checkbox" name="book" class="book" value="Checkbox 3"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="200"/></td>
</tr>
<tr>
<td><input type="checkbox" name="book" class="book" value="Checkbox 4"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="300"/></td>
<td><input type="checkbox" name="book" class="book" value="Checkbox 5"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="200"/></td>
<td><input type="checkbox" name="book" class="book" value="Checkbox 6"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="200"/></td>
</tr>
<tr>
<td><input type="checkbox" name="book" class="book" value="Checkbox 7"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="400"/></td>
<td><input type="checkbox" name="book" class="book" value="Checkbox 8"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="400"/></td>
<td><input type="checkbox" name="book" class="book" value="Checkbox 9"/></td>
<td><input type="text" name="bookprice"class="bookprice" value="400"/></td>
</tr>
<tr>
<td><div class="button"><a href="#" onClick="submitbookdata();">Save !</a></div></td>
</tr>
</table>
</body>
</html>