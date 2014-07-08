short parity( unsigned long x) {
  short reulst = 0;
  while(x) {
    result ^= (x  & 1)
    x >>= 1;
  }
  return result;
}
