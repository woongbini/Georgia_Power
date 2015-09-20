<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/jquery.tagit.css" rel="stylesheet" type="text/css">
<link href="css/tagit.ui-zendesk.css" rel="stylesheet" type="text/css">

<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"	type="text/javascript" charset="utf-8"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"	type="text/javascript" charset="utf-8"></script>
<script src="js/tag-it.js" type="text/javascript" charset="utf-8"></script>
<script>
	$('#tags').ready(
			$(function(){
            var sampleTags = [];

            
            //-------------------------------
            // Single field
            //-------------------------------
          

            // singleFieldTags2 is an INPUT element, rather than a UL as in the other 
            // examples, so it automatically defaults to singleField.
            $('#singleFieldTags2').tagit({
                availableTags: sampleTags
            });

            
            //-------------------------------
            // Tag events
            //-------------------------------
            var eventTags = $('#eventTags');

            var addEvent = function(text) {
                $('#events_container').append(text + '<br>');
            };

            eventTags.tagit({
                availableTags: sampleTags,
                beforeTagAdded: function(evt, ui) {
                    if (!ui.duringInitialization) {
                        addEvent('beforeTagAdded: ' + eventTags.tagit('tagLabel', ui.tag));
                    }
                },
                afterTagAdded: function(evt, ui) {
                    if (!ui.duringInitialization) {
                        addEvent('afterTagAdded: ' + eventTags.tagit('tagLabel', ui.tag));
                    }
                },
                beforeTagRemoved: function(evt, ui) {
                    addEvent('beforeTagRemoved: ' + eventTags.tagit('tagLabel', ui.tag));
                },
                afterTagRemoved: function(evt, ui) {
                    addEvent('afterTagRemoved: ' + eventTags.tagit('tagLabel', ui.tag));
                },
                onTagClicked: function(evt, ui) {
                    addEvent('onTagClicked: ' + eventTags.tagit('tagLabel', ui.tag));
                },
                onTagExists: function(evt, ui) {
                    addEvent('onTagExists: ' + eventTags.tagit('tagLabel', ui.existingTag));
                }
            });



        }));
    </script>
    
   

<title>tag.jsp</title>
</head>
<body>


	<h3>
		<a name="graceful-degredation"></a>single
	</h3>
	<form id="tagform" action="mydb" name="tag_name" method="post">
		<p>ID태그하기</p>
		<input name="tags" id="singleFieldTags2" >
		<input type="hidden" id="tag_nickname" name="tag_nickname">
		<input type="hidden" name="command" value="tag_name">
		<input type="button" id="btn" value="태그완료" />	
		</form>
		
		 
		 <script>
        $(document).ready(function () {
            $('#btn').on('click', function () {
                var str = '';
                 tag_name = [];
 				
 				for (var i = 0; i < $('ul .tagit-label').length; i++)
                {
                    tag_name.push(new String($('ul .tagit-label').eq(i).html()));
                }
                alert(tag_name);
                document.getElementById('tag_nickname').value = tag_name;
                document.getElementById('tagform').submit();
               
                
                alert(1);
            });
        });
    </script>
		
</body>
</html>