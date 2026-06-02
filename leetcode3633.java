class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int minLandFinish = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            minLandFinish = Math.min(
                minLandFinish,
                landStartTime[i] + landDuration[i]
            );
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < waterStartTime.length; j++) {
            ans = Math.min(
                ans,
                Math.max(minLandFinish, waterStartTime[j])
                + waterDuration[j]
            );
        }

        int minWaterFinish = Integer.MAX_VALUE;

        for (int j = 0; j < waterStartTime.length; j++) {
            minWaterFinish = Math.min(
                minWaterFinish,
                waterStartTime[j] + waterDuration[j]
            );
        }

        for (int i = 0; i < landStartTime.length; i++) {
            ans = Math.min(
                ans,
                Math.max(minWaterFinish, landStartTime[i])
                + landDuration[i]
            );
        }

        return ans;
    }
}
