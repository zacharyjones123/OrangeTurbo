				byte input1[] = { '0', '7', '0', '1' };
				byte input2[] = { '0', '9', '0', '1' };
				byte input3[] = { '1', '1', '0', '1' };
				byte input4[] = { '1', '3', '0', '1' };

				codes.setACode(1, input1);
				codes.setACode(2, input2);
				codes.setACode(3, input3);
				codes.setACode(4, input4);

				output.write(codes.getACode(1));
				output.write(codes.getACode(2));
				output.write(codes.getACode(3));
				output.write(codes.getACode(4));