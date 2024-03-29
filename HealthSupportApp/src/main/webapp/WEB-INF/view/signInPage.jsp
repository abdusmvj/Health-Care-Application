<link href="static/css/style.css" rel="stylesheet">
<!-- Modal -->
<div class="modal fade" id="elegantModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <!--Content-->
    <div class="modal-content form-elegant">
      <!--Header-->
      <div class="modal-header text-center">
        <h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel"><strong>Sign in</strong></h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <!--Body-->
      <div class="modal-body mx-4">
        <!--Body-->
<!--         <div class="md-form mb-5"> -->
          <input type="email" id="Form-email1" class="form-control validate">
          <label data-error="wrong" data-success="right" for="Form-email1">Your email</label>
        </div>

        <div class="md-form pb-3">
          <input type="password" id="Form-pass1" class="form-control validate">
          <label data-error="wrong" data-success="right" for="Form-pass1">Your password</label>
          <p class="font-small blue-text d-flex justify-content-end">Forgot <a href="#" class="blue-text ml-1">
              Password?</a></p>
        </div>

        <div class="text-center mb-3">
          <button type="button" class="btn blue-gradient btn-block btn-rounded z-depth-1a">Sign in</button>
        </div>
        <p class="font-small dark-grey-text text-right d-flex justify-content-center mb-3 pt-2"> or Sign in
          with:</p>

        <div class="row my-3 d-flex justify-content-center">
          <!--Facebook-->
          <button type="button" class="btn btn-white btn-rounded mr-md-3 z-depth-1a"><i class="fab fa-facebook-f text-center"></i></button>
          <!--Twitter-->
          <button type="button" class="btn btn-white btn-rounded mr-md-3 z-depth-1a"><i class="fab fa-twitter"></i></button>
          <!--Google +-->
          <button type="button" class="btn btn-white btn-rounded z-depth-1a"><i class="fab fa-google-plus-g"></i></button>
        </div>
      </div>
      <!--Footer-->
      <div class="modal-footer mx-5 pt-3 mb-1">
        <p class="font-small grey-text d-flex justify-content-end">Not a member? <a href="#" class="blue-text ml-1">
            Sign Up</a></p>
      </div>
    </div>
    <!--/.Content-->
  </div>
</div>
<!-- Modal -->

     
        <label>Select Date: </label>
<div id="datepicker" class="input-group date" data-date-format="dd-mm-yyyy">
    <input class="form-control" type="text" readonly />
    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
</div>
        <script type="text/javascript">
            $(function () {
                
            	var todaysDate = getTodayDate();
            	// $("#datepicker").val(todaysDate);
            	function getTodayDate() {
            		   var tdate = new Date();
            		   var dd = tdate.getDate(); //yields day
            		   var MM = tdate.getMonth(); //yields month
            		   var yyyy = tdate.getFullYear(); //yields year
            		   var currentDate= dd + "-" +( MM+1) + "-" + yyyy;

            		   return currentDate;
            		}
            	$("#datepicker").datepicker({ 
                    autoclose: true, 
                    todayHighlight: true,
                    "setDate": new Date()
              }).datepicker('update', new Date());
            });
           
        </script>
        
       <div class="input-group" id="clockpicker">
    <input type="text" class="form-control">
    <span class="input-group-addon">
        <span class="glyphicon glyphicon-time"></span>
    </span>
</div>
<script type="text/javascript">
$(function () {
	console.log("today time is "+new Date($.now()));
$('#clockpicker').clockpicker({
    placement: 'top',
    align: 'left',
    donetext: 'Done',
    'default': new Date($.now()),	
    	   twelvehour: true,
    	   autoclose: false,
    	   leadingZeroHours: false

});
});
</script>

