// @SOURCE:/home/mgordo/workspace/mongogo/conf/routes
// @HASH:5bc3285636a9c9060f83b52615d5d20482f62716
// @DATE:Sat Mar 30 00:43:20 EDT 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def group(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "groups")
}
                                                

// @LINE:10
def deleteGroup(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "groups/" + implicitly[PathBindable[String]].unbind("id", id) + "/delete")
}
                                                

// @LINE:9
def newGroup(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "groups")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def group : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.group",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "groups"})
      }
   """
)
                        

// @LINE:10
def deleteGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteGroup",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "groups/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:9
def newGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newGroup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "groups"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def group(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.group(), HandlerDef(this, "controllers.Application", "group", Seq(), "GET", """""", _prefix + """groups""")
)
                      

// @LINE:10
def deleteGroup(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteGroup(id), HandlerDef(this, "controllers.Application", "deleteGroup", Seq(classOf[String]), "POST", """""", _prefix + """groups/$id<[^/]+>/delete""")
)
                      

// @LINE:9
def newGroup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newGroup(), HandlerDef(this, "controllers.Application", "newGroup", Seq(), "POST", """""", _prefix + """groups""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      