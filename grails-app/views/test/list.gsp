<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Main Page</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Available Links</h1>

        <div id="controllers" role="navigation">
            <ul>
                <li class="controller">
                    <g:link action="testQuery" >
                        Test Query
                    </g:link>
                </li>

                <li class="controller">
                    <g:link action="testError" >
                        Test Error
                    </g:link>
                </li>


                <li class="controller">
                    <g:link action="testScope" >
                        Test Scope
                    </g:link>
                </li>


                <li class="controller">
                    <g:link action="testData" >
                        Test Data
                    </g:link>
                </li>

                <li class="controller">
                    <g:link action="testDataCustom" >
                        Test Data Custom
                    </g:link>
                </li>

                <li class="controller">
                    <g:link action="testChain" >
                        Test Data Chain
                    </g:link>
                </li>



            </ul>
        </div>
    </section>

</div>


</body>
</html>
