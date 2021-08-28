# Infinite ViewPager2

Achieve the smooth bi-directional infinite scrolling ViewPager 2

## The Problem

You can slide from the very first view till the last view and that’s it. You can’t scroll backward to the last view from the first view and forward from the last view to the first view. This problem can make it cumbersome for the user to scroll through views on the ViewPager2.

![](https://miro.medium.com/max/4800/1*W0jri2VlW5jgOw7VCo3VGA.png)

## The Solution

So, our target is to make the user able to scroll directly from the first view to the last view with backward scroll and from the last view to the first view with forward scroll.
So basically to make a workaround for infinite scrolling views on the ViewPager2 we have to go like

* First, add a fake first view after the actual last view and also add a fake last view before the actual first view.
![](https://miro.medium.com/max/1400/1*rGK0XsaFvnXvYXjif74EPg.png)
* When the user is on fake last view, replace it with the actual last view and when the user is on the fake first view, replace it with the actual first view.
![](https://miro.medium.com/max/1400/1*A68uou1FO0MURxyxf1R6BQ.png)

### This whole code is expained on my medium blog post. Give it a shot!

### [[Read it here]](https://medium.com/@ashishpandey.professional/android-infinite-scrolling-viewpager2-195e3786ec3f)

