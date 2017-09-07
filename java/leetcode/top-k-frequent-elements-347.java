public List<Integer> topKFrequent(int[] nums, int k) {
  HashMap<Integer, Integer> map = new HashMap<>();

  // Make a frequency map.
  for (int i : nums) {
    map.put(i, map.getOrDefault(i, 0) + 1);
  }

  // Reverse the map so that the frequency is the index.
  // Store in some sort of data structure where the indices are sorted 
  // so that we can iterate from most frequent to least frequent.
  List<HashSet<Integer>> list = new ArrayList<>();

  // Populate the entire list.
  for (int i = 0; i <= nums.length; i ++) {
    list.add(new HashSet<Integer>());
  }

  for (int key : map.keySet()) {
    int frequency = map.get(key);

    // Add the value into the hash set, indexed by the frequency.
    list.get(frequency).add(key);
  }

  // Now iterate and grab the k most frequenct elements.
  List<Integer> result = new ArrayList<>();
  for (int i = list.size() - 1; i >= 0 && k > 0; i --) {
    HashSet<Integer> set = list.get(i);

    for (int value : set) {
      if (k <= 0) {
        break;
      }

      result.add(value);
      k --;
    }
  }

  return result;
}
