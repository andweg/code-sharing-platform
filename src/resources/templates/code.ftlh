<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Code</title>
        <style>
            #date{
                color: green;
            }
            #snippet{
                border: 1px solid gray;
                background-color: lightgray;
            }
        </style>
        <link rel="stylesheet"
            href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
            <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
            <script>hljs.initHighlightingOnLoad();</script>
    </head>
    <body>
        <pre id="code_snippet">
            <code>${code}</code>
        </pre>
        <span id="load_date">
            ${date}
        </span>
        <#if isViewsRestricted>
            <span id="views_restriction">${views} more views allowed</span>
        </#if>
        <#if isTimeRestricted>
            <span id="time_restriction">The code will be available for ${time} seconds</span>
        </#if>
    </body>
</html>