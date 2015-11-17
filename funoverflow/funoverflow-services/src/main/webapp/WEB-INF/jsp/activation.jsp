<!DOCTYPE html>
<!--
 * A Design by GraphBerry
 * Author: GraphBerry
 * Author URL: http://graphberry.com
 * License: http://graphberry.com/pages/license
-->
<html lang="en">
    
    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pluton Theme by BraphBerry.com</title>
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/pluton.css" />
        <!--[if IE 7]>
            <link rel="stylesheet" type="text/css" href="css/pluton-ie7.css" />
        <![endif]-->
        <link rel="stylesheet" type="text/css" href="resources/css/jquery.cslider.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/jquery.bxslider.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/animate.css" />
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/images/ico/apple-touch-icon-144.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/images/ico/apple-touch-icon-114.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/images/apple-touch-icon-72.png">
        <link rel="apple-touch-icon-precomposed" href="resources/images/ico/apple-touch-icon-57.png">
        <link rel="shortcut icon" href="resources/images/ico/favicon.ico">
        
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
    </head>
    
    <body ng-app="myapp" ng-controller="HelloController">
        
    
        <!-- Portfolio section start -->
        <div class="section secondary-section " id="portfolio">
            <div class="triangle"></div>
            <div class="container">
                
                <ul class="nav nav-pills">
                    <li class="filter" data-filter="all">
                        <a href="#noAction">All</a>
                    </li>
                    <li class="filter" data-filter="web">
                        <a href="#noAction">Web</a>
                    </li>
                    <li class="filter" data-filter="photo">
                        <a href="#noAction">Photo</a>
                    </li>
                    <li class="filter" data-filter="identity">
                        <a href="#noAction">Identity</a>
                    </li>
                </ul>
                <!-- Start details for portfolio project 1 -->
                <div id="single-project">
                    <div id="slidingDiv" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[0].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[0].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[0].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[0].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 1 -->
                    <!-- Start details for portfolio project 2 -->
                    <div id="slidingDiv1" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[1].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[1].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[1].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[1].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 2 -->
                    <!-- Start details for portfolio project 3 -->
                    <div id="slidingDiv2" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[2].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[2].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[2].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[2].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 3 -->
                    <!-- Start details for portfolio project 4 -->
                    <div id="slidingDiv3" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[3].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[3].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[3].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[3].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 4 -->
                    <!-- Start details for portfolio project 5 -->
                    <div id="slidingDiv4" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[4].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[4].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[4].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[4].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 5 -->
                    <!-- Start details for portfolio project 6 -->
                    <div id="slidingDiv5" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[5].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[5].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[5].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[5].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 6 -->
                    <!-- Start details for portfolio project 7 -->
                    <div id="slidingDiv6" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[6].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[6].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[6].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[6].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 7 -->
                    <!-- Start details for portfolio project 8 -->
                    <div id="slidingDiv7" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[7].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[7].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[7].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[7].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 8 -->
                    <!-- Start details for portfolio project 9 -->
                    <div id="slidingDiv8" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{githubImageUrl}}/{{funOverflowImages[8].imageurl_l}}" alt="loading..." />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3 ng-bind="funOverflowImages[8].title"></h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    
                        
                                    <div>
                                        <span>Skills</span><span ng-repeat="tag in funOverflowImages[8].tags"><span ng-bind="tag"></span> &nbsp &nbsp</span></div>
                                    
                                </div>
                                <p ng-bind="funOverflowImages[8].description"></p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 9 -->
                    <ul id="portfolio-grid" class="thumbnails row">
                        <li class="span4 mix web fixedHeightWidht640400">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[0].imageurl_l}}" alt="loading...">
                                <a href="#single-project" class="more show_hide" rel="#slidingDiv">
                                    <i class="icon-plus"></i>
                                </a>   
                                                           
                                <p ng-bind="funOverflowImages[0].title"></p>
                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix photo fixedHeightWidht640400">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[1].imageurl_l}}" alt="loading...">
                                <a href="#single-project" class="show_hide more" rel="#slidingDiv1">
                                    <i class="icon-plus"></i>
                                </a>
                                <p ng-bind="funOverflowImages[1].title"></p>
                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix identity fixedHeightWidht640400">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[2].imageurl_l}}" alt="loading...">
                                <a href="#single-project" class="more show_hide" rel="#slidingDiv2">
                                    <i class="icon-plus"></i>
                                </a>
                                <p ng-bind="funOverflowImages[2].title"></p>
                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix web">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[3].imageurl_l}}" alt="loading...">
                                <a href="#single-project" class="show_hide more" rel="#slidingDiv3">
                                    <i class="icon-plus"></i>
                                </a>
                                <p ng-bind="funOverflowImages[3].title"></p>
                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix photo">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[4].imageurl_l}}" alt="loading...">
                                <a href="#single-project" class="show_hide more" rel="#slidingDiv4">
                                    <i class="icon-plus"></i>
                                </a>
                                <p ng-bind="funOverflowImages[4].title"></p>
                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix identity">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[5].imageurl_l}}" alt="loading...">
                                <a href="#single-project" class="show_hide more" rel="#slidingDiv5">
                                    <i class="icon-plus"></i>
                                </a>
                                <p ng-bind="funOverflowImages[5].title"></p>
                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix web">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[6].imageurl_l}}" alt="loading..." />
                                <a href="#single-project" class="show_hide more" rel="#slidingDiv6">
                                    <i class="icon-plus"></i>
                                </a>
                                <p ng-bind="funOverflowImages[6].title"></p>
                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix photo">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[7].imageurl_l}}" alt="loading...">
                                <a href="#single-project" class="show_hide more" rel="#slidingDiv7">
                                    <i class="icon-plus"></i>
                                </a>
                                <p ng-bind="funOverflowImages[7].title"></p>
                                
                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix identity">
                            <div class="thumbnail">
                                <img src="{{githubImageUrl}}/{{funOverflowImages[8].imageurl_l}}" alt="loading...">
                                <a href="#single-project" class="show_hide more" rel="#slidingDiv8">
                                    <i class="icon-plus"></i>
                                </a>
                                <p ng-bind="funOverflowImages[8].title"></p>
                                <div class="mask"></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            
            <ul class="pagination">
              <li style="display: inline;"><a href="#" ng-click="goPrevPage()">prev</a></li>
			  <li style="display: inline;"><a href="#" ng-click="goToPage(pageNo)" ng-bind="pageNo"></a></li>
			  <li style="display: inline;"><a href="#" ng-click="goToPage(pageNo2)" ng-bind="pageNo2"></a></li>
			  <li style="display: inline;"><a href="#" ng-click="goToPage(pageNo3)" ng-bind="pageNo3"></a></li>
			  <li style="display: inline;"><a href="#" ng-click="goToPage(pageNo4)" ng-bind="pageNo4"></a></li>
			  <li style="display: inline;"><a href="#" ng-click="goToPage(pageNo5)" ng-bind="pageNo5"></a></li>
			  <li style="display: inline;"><a href="#" ng-click="goNextPage()">next</a></li>
			</ul>

        </div>
        <!-- Portfolio section end -->
        
        
        <!-- Footer section start -->
        <div class="footer">
            <p>&copy; 2013 Theme by <a href="http://www.graphberry.com">GraphBerry</a>, <a href="http://goo.gl/NM84K2">Documentation</a></p>
        </div>
        <!-- Footer section end -->
        <!-- ScrollUp button start -->
        <div class="scrollup">
            <a href="#">
                <i class="icon-up-open"></i>
            </a>
        </div>
        <!-- ScrollUp button end -->
        <!-- Include javascript -->
        <script src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/jquery.mixitup.js"></script>
        <script type="text/javascript" src="resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="resources/js/modernizr.custom.js"></script>
        <script type="text/javascript" src="resources/js/jquery.bxslider.js"></script>
        <script type="text/javascript" src="resources/js/jquery.cslider.js"></script>
        <script type="text/javascript" src="resources/js/jquery.placeholder.js"></script>
        <script type="text/javascript" src="resources/js/jquery.inview.js"></script>
        <!-- css3-mediaqueries.js for IE8 or older -->
        <!--[if lt IE 9]>
            <script src="resources/js/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="resources/js/app.js"></script>
        <script>
        
        angular.module("myapp", [])
        .controller("HelloController", function($scope) {
           
            $scope.githubImageUrl = "https://raw.githubusercontent.com/sumitc91/xyzfun/develop/funoverflow/funoverflow-services/src/main/webapp/resources/images";
            $scope.funOverflowImages=[];
            var queryStringPageNo = getParameterByName('pageNo');
            console.log("queryStringPageNo : "+queryStringPageNo);
            $scope.pageNo=1;
            if(queryStringPageNo==null || queryStringPageNo ==''){
            	$scope.pageNo=1;
            }
            else
            {
            	$scope.pageNo=queryStringPageNo;	
            }
            $scope.pageNo2=$scope.pageNo+1;
            $scope.pageNo3=$scope.pageNo+2;
            $scope.pageNo4=$scope.pageNo+3;
            $scope.pageNo5=$scope.pageNo+4;
            $scope.fetchFrom=(($scope.pageNo-1)*10);
            $scope.fetchUpto=$scope.fetchFrom+9;
            
            $scope.goPrevPage = function () {
                //alert("prev page");
                if($scope.pageNo==1)
                	{
                		alert("you are already at first page.")
                	}
                else
                	{
                		location.href = "?pageNo="+$scope.pageNo-1;
                		/* $scope.pageNo=$scope.pageNo-1;
                		$scope.pageNo2=$scope.pageNo+1;
                        $scope.pageNo3=$scope.pageNo+2;
                        $scope.pageNo4=$scope.pageNo+3;
                        $scope.pageNo5=$scope.pageNo+4;
                        
                		$scope.fetchFrom=(($scope.pageNo-1)*10);
                        $scope.fetchUpto=$scope.fetchFrom+9; */
                        
                	}
                $scope.$apply();
                refreshPage();
            };
            
            $scope.goNextPage = function () {
                //alert("next page");
                location.href = "?pageNo="+$scope.pageNo+1;
                /* $scope.pageNo=$scope.pageNo+1;
                $scope.pageNo2=$scope.pageNo+1;
                $scope.pageNo3=$scope.pageNo+2;
                $scope.pageNo4=$scope.pageNo+3;
                $scope.pageNo5=$scope.pageNo+4;
                console.log("$scope.pageNo : "+$scope.pageNo);
                $scope.fetchFrom=(($scope.pageNo-1)*10);
                console.log("$scope.fetchFrom : "+$scope.fetchFrom);
                $scope.fetchUpto=$scope.fetchFrom+9;
                console.log("$scope.fetchUpto : "+$scope.fetchUpto);
                $scope.$apply();
                refreshPage(); */
            };
            
            $scope.goToPage = function (id) {
                //alert(id);  
                $scope.pageNo=id-1;
             
                $scope.pageNo2=$scope.pageNo+1;
                $scope.pageNo3=$scope.pageNo2+1;
                $scope.pageNo4=$scope.pageNo3+1;
                $scope.pageNo5=$scope.pageNo4+1;
                $scope.fetchFrom=(($scope.pageNo-1)*10);
                $scope.fetchUpto=$scope.fetchFrom+9;
                $scope.$apply();
                refreshPage();
            };
            
            
            refreshPage();
            
            function refreshPage() {
            	var url = '/funoverflow-services/getFunOverflowImages?fetchFrom='+$scope.fetchFrom+'&fetchUpto='+$scope.fetchUpto;
                var headers = {
                   'Content-Type': 'application/json'						                      
               }; 
            	$.ajax({
    				url: url,
    				method: "GET",
                   headers: headers
    				}).done(function(data,status) {
    					console.log(data);
    					
    					if(data.Response.responseCode == "200")
    					{
    						$scope.funOverflowImages=data.Response.responseDetails.data;
    						$scope.helloTo = "updated angular js";
    						
    						$scope.$apply();
    						console.log($scope.funOverflowImages);
    						//alert("success")
    					}
    					else 
    					{
    						alert("server error occured!");
    					}
    				});
            }
			
			
        } );
        
        function getParameterByName(name) {
            name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
            return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
        }
		
                    
				
</script>
    </body>
</html>