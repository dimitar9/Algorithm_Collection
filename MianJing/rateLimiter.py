rate = 5.0; // unit: messages
per  = 8.0; // unit: seconds
allowance = rate; // unit: messages
last_check = now(); // floating-point, e.g. usec accuracy. Unit: seconds

when (message_received):
  current = now();
  time_passed = current - last_check;
  last_check = current;
  allowance += time_passed * (rate / per);
  if (allowance > rate):
    allowance = rate; // throttle
  if (allowance < 1.0):
    discard_message();
  else:
    forward_message();
    allowance -= 1.0;
    
    
    
	
#That is a standard algorithm—it's a token bucket, without queue. The bucket is allowance. The bucket size is rate. 
#The allowance += … line is an optimization of adding a token every rate ÷ per seconds.
