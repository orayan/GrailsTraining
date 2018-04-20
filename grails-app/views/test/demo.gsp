<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>



<g:hasErrors bean="${country}">
    <div class="errors">
        <g:renderErrors bean="${country}" as="list" />
    </div>
</g:hasErrors>

</body>
</html>
