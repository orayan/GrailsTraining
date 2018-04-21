<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Test Error Domain</title>
</head>
<body>


%{--render domain class error--}%
<g:hasErrors bean="${country}">
    <div class="errors">
        <g:renderErrors bean="${country}" as="list" />
    </div>
</g:hasErrors>

</body>
</html>
