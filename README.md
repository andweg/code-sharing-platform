# Code Sharing Platform
Simple REST service application for sharing code snippets.

## Endpoints
* ```GET /api/code/{uuid}``` returns the code snippet with the specified UUID
* ```GET /api/code/latest``` returns 10 most recently added code snippets
* ```POST /api/code/new``` adds a new code snippet

## Pages
* ```/code/{uuid}``` displays the code snippet with the specified UUID
* ```/code/latest``` displays 10 most recently added code snippets
* ```/code/new``` displays a form allowing for posting a new code snippet

## Sources
This application was created as a graduate project for the [JetBrains Academy](https://www.jetbrains.com/academy/)'s Java Backend track.
