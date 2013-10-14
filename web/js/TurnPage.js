/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-6
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
function Jumping(){
    document.PageForm.submit();
    return ;
}
function gotoPage(pagenum){
    document.PageForm.jumpPage.value = pagenum;
    document.PageForm.submit();
    return ;
}