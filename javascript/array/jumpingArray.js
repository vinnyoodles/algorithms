/**
 * Given an array of non-negative integers, starting at the beginning of the array where each
 * element in the array represents your maximum jumping distance at that position.
 * Determine if reaching the end index is possible.
 *
 * @param  {Array} array
 * @return {Boolean}
 */
 function jumpingArray(array) {
   // Start the pointer at the end of the array.
   var pointer = array.length - 1;

   for (var i = array.length - 1; i >= 0; i --) {

     // If the current index is able to reach the pointer, then update the pointer
     if (i + array[i] >= pointer) pointer = i;
   }

   // The pointer must be at the start index if there is a viable path.
   return pointer === 0;
 }

 module.exports = jumpingArray;
