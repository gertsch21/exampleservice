
<div class="panel panel-default">
    <div class="panel-body">

<h2>${ergebnis}</h2>
<form method="POST" action="">
    <h2>Neues Topic:</h2>
    Topicname: <textarea id="topic_name" name="topic_name" rows="1" cols="50"></textarea>
    <br>
    <input type="submit">

    <br><br>

    <h2>Neuer Post:</h2>
    Subject: <input type="text" name="post_subject"/><br>
    Text: <textarea name="post_text" rows="3" cols="50"></textarea><br>
    Topic Name: <input list="topic_name_post" name="topic_name_post">
    <datalist id="topic_name_post">
        <#list topics as topic>
            <option value="${topic.name}">
        </#list>
    </datalist>
    <br>
    <input type="submit">

    <br><br>

    <h2>Neuer Comment:</h2>
    Subject: <input type="text" name="comment_subject"/><br>
    Text: <textarea name="comment_text" rows="3" cols="50"></textarea><br>
    Postsubject: <input list="post_subject_comment" name="post_subject_comment">
    <datalist id="post_subject_comment">
        <#list posts as post>
            <option value="${post.subject}">
        </#list>
    </datalist>
    <br>
    <input type="submit">
</form>
<div>
<div>
