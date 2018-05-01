public static int kEmptySlots2(int[] flowers, int k) {
        if (k == flowers.length) return flowers.length;
       
// days[i] means the flower at position i will blossom at day days[i]
        int[] temp =  new int[flowers.length];
        for(int i=0; i<flowers.length; i++)temp[flowers[i] - 1] = i + 1;

        int[] days = new int[temp.length + 2];

//init left and right bound of the garden to take care of edge cases
        days[0] = Integer.MAX_VALUE;
        days[days.length - 1] = temp.length + 1;
        for (int i = 1; i <= temp.length; i++){
            days[i] = temp[i - 1];
        }


//build a sliding window of size k, left and right would be the bounds of the window
        int left = 0, right = k + 1, res = Integer.MIN_VALUE;
        int latest = Integer.MIN_VALUE;

        for(int i = 0; right < days.length; i++){
            System.out.printf("i: %d, left: %d, right: %d\n", i, left, right);
            System.out.printf("day[i]: %d, day[left]: %d, day[right]: %d\n", days[i], days[left], days[right]);

//if any flower which is between the bounds of the window blossoms later than the bounds, just update the possible latest day and the window
            if(days[i] >= days[left] || days[i] >= days[right]){
                if (i == right && latest != Integer.MIN_VALUE){
                    res = Math.max(res, latest);
                    latest = Integer.MIN_VALUE;
                    System.out.println("res: " + res);
                }
                left = i;
                right = k + 1 + i;
                System.out.printf("update: left: %d, right: %d\n", left, right);

            }else{
//if the flower which is between the bounds will blossom earlier than the bounds, updates latest to the latest day that flowers may blossom within the window
                latest = Math.max(latest, Math.min(days[left], days[right]) - 1);
                System.out.println("latest: " + latest);
            }
        }
        return (res == Integer.MIN_VALUE)?-1:res;
    }
