<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Create</title>
    </head>
    <body>
        <form action="/api/code/new" method="post">
            <div>
                  <label>type your code here:</label><br>
                  <textarea id=code_snippet cols="50" rows="25">...</textarea>
            </div>
            <div>
                  <label>time restriction in seconds:</label>
                  <input id="time_restriction" type="text" value="0"/>
            </div>
            <div>
                  <label>number of views allowed:</label>
                  <input id="views_restriction" type="text" value="0"/>
            </div>
            <button id="send_snippet" onclick="send()" type="submit">Submit</button>
        </form>
        <script>
            function send() {
                let object = {
                    code: document.getElementById("code_snippet").value,
                    time: document.getElementById("time_restriction").value,
                    views: document.getElementById("views_restriction").value
                };

                let json = JSON.stringify(object);

                let xhr = new XMLHttpRequest();
                xhr.open("POST", '/api/code/new', false)
                xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
                xhr.send(json);

                if (xhr.status === 200) {
                    alert("Success!");
                } else {
                    alert("Failure")
                }
            }
        </script>
    </body>
</html>