<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Latest</title>
        <style>
            #date{
                color: green;
            }
            #code{
                border: 1px solid black;
                background-color: gray;
            }
        </style>
        <link rel="stylesheet"
            href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
        <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
    </head>
    <body>
        <div>
            <#list snippets as snippet>
                <span id="date">${snippet.date}</span>
                <pre id="code"><code>${snippet.code}</code></pre>
            </#list>
        </div>
    </body>
</html>