struct Ans {
    from: u32,
    to: u32,
}

struct Boj11400 {
    table: std::collections::HashMap<u32, Vec<u32>>,
    ans: Vec<Ans>, 
    seq_num: u32,
    seq_arr: Vec<u32>,
}

impl Boj11400 {
    pub fn new() -> Boj11400{
        let mut arr = Vec::with_capacity(100001);
        for i in 0..100001 {
            arr.push(0);
        }

        Boj11400 {
            table: std::collections::HashMap::new(),
            ans: Vec::new(),
            seq_num: 1,
            seq_arr: arr
        }
    }

    fn parse_input(num: &String) -> Vec<u32> {
        let ret: Vec<u32> = 
            num.trim()
            .split_whitespace()
            .map(|w| w.parse()
            .expect("Not an integer."))
            .collect();
        ret
    }

    pub fn print_data(&mut self) {
        for (k, v) in self.table.iter() {
            print!("{} > ", k);
            for v in v.iter() {
                print!("{} ", v);
            }
            println!("")
        }
    }

    pub fn input_data(&mut self) -> Result<(), std::io::Error> {
        let mut num = String::new();
        std::io::stdin().read_line( &mut num)?;
        let nm: Vec<u32> = Self::parse_input(&num);

        for i in 0..nm[1] {
            num.clear();
            std::io::stdin().read_line( &mut num)?;
            let vv = Self::parse_input(&num);
            if self.table.contains_key(&vv[0]) {
                let vt = self.table.get_mut(&vv[0]).unwrap();
                vt.push(vv[1]);
            } else {
                self.table.insert(vv[0], vec![vv[1]]);
            }
        }

        Ok(())
    }

    pub fn solve(&mut self, cur: u32, pos: u32) -> u32 {
        self.seq_arr[cur as usize] = self.seq_num;
        self.seq_num += 1;
        let mut ret: u32 = self.seq_arr[cur as usize];
        let cur_link = self.table.get_mut(&cur).unwrap();
        for other_node in cur_link {
            if *other_node == pos {
                continue;
            }

            if self.seq_arr[*other_node as usize] != 0 {
                let df = self.solve(other_node.clone(), pos);
                if df > self.seq_arr[cur as usize] {
                    self.ans.push(
                        Ans {
                            to: std::cmp::min(cur, *other_node),
                            from: std::cmp::max(cur, *other_node),
                        }
                    )
                }
            }
        }
        ret
    }
}

fn main() -> Result<(), std::io::Error> {
    let mut prob = Boj11400::new();
    prob.input_data()?;
    prob.print_data();
    Ok(())
}
