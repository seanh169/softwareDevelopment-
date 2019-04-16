<template>
<div id="form" class="form-group text-center">
    
    <label for="reports">Select Office: </label>
    <select class="form-control" id="reports">
      <option>Ground</option>
      <option>Science</option>
      <option>Flight</option>
      <option>Program Ooffice</option>
      
    </select>
    <label for="year">Select Year: </label>
    <select class="form-control" id="year">
      <option>2015</option>
      <option>2016</option>
      <option>2017</option>
      <option>2018</option>
      
    </select>
    <label for="month">Select Month: </label>
    <select class="form-control" id="month">
      <option>January</option>
      <option>Feb</option>
      <option>March</option>
      <option>April</option>
      
    </select>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" id="POR Report" value="option1">
        <label class="form-check-label" for="POR Report">POR Report</label><br>
        <input class="form-check-input" type="checkbox" id="PFO Report" value="option1">
        <label class="form-check-label" for="PFO Report">PFO Report</label>

    </div>


</div>



</template>
    
<script>




</script>


<style scoped>

#form{
    margin: 0 auto;
    float: none;
    
}


</style>
