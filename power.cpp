public double power(double x, int n) {
	if (n == 0)
		return 1;
 
	double v = power(x, n / 2);
 
	if (n % 2 == 0) {
		return v * v;
	} else {
		return v * v * x;
	}
}
 
public double pow(double x, int n) {
	if (n < 0) {
		return 1 / power(x, -n);
	} else {
		return power(x, n);
	}
}
