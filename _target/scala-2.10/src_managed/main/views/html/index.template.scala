
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Group],Form[Group],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(groups: List[Group], groupForm: Form[Group]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.47*/(""" 

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Groups")/*5.16*/ {_display_(Seq[Any](format.raw/*5.18*/("""
  
  <h1>"""),_display_(Seq[Any](/*7.8*/groups/*7.14*/.size())),format.raw/*7.21*/(""" task(s)</h1>
  
  <ul>
    """),_display_(Seq[Any](/*10.6*/for(group <- groups) yield /*10.26*/ {_display_(Seq[Any](format.raw/*10.28*/("""
      <li>"""),_display_(Seq[Any](/*11.12*/group/*11.17*/.groupName)),format.raw/*11.27*/(""" / """),_display_(Seq[Any](/*11.31*/group/*11.36*/.date)),format.raw/*11.41*/("""
      """),_display_(Seq[Any](/*12.8*/form(routes.Application.deleteGroup(group.id.toString()))/*12.65*/ {_display_(Seq[Any](format.raw/*12.67*/(""" 
         <input type="submit" value="Delete"> 
      """)))})),format.raw/*14.8*/("""
      </li>
    """)))})),format.raw/*16.6*/("""
  </ul>
  
  <h2>Add a new task</h2>
  
  """),_display_(Seq[Any](/*21.4*/form(routes.Application.newGroup())/*21.39*/ {_display_(Seq[Any](format.raw/*21.41*/("""
     """),_display_(Seq[Any](/*22.7*/inputText(groupForm("groupName")))),format.raw/*22.40*/(""" """),_display_(Seq[Any](/*22.42*/inputDate(groupForm("date")))),format.raw/*22.70*/("""
     <input type="submit" value="Create">
  
  """)))})),format.raw/*25.4*/(""" 

""")))})),format.raw/*27.2*/("""
"""))}
    }
    
    def render(groups:List[Group],groupForm:Form[Group]): play.api.templates.Html = apply(groups,groupForm)
    
    def f:((List[Group],Form[Group]) => play.api.templates.Html) = (groups,groupForm) => apply(groups,groupForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Mar 30 00:43:20 EDT 2013
                    SOURCE: /home/mgordo/workspace/mongogo/app/views/index.scala.html
                    HASH: 6f7e4c2623ee11e143fea43bfb0b75e051d3bd98
                    MATRIX: 740->1|878->46|907->66|943->68|965->82|1004->84|1049->95|1063->101|1091->108|1155->137|1191->157|1231->159|1279->171|1293->176|1325->186|1365->190|1379->195|1406->200|1449->208|1515->265|1555->267|1642->323|1691->341|1770->385|1814->420|1854->422|1896->429|1951->462|1989->464|2039->492|2119->541|2154->545
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|42->14|44->16|49->21|49->21|49->21|50->22|50->22|50->22|50->22|53->25|55->27
                    -- GENERATED --
                */
            