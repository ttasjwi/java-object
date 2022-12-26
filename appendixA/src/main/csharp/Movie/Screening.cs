using System;
using Monetary;
using System.Diagnostics.Contracts;

namespace MovieReservation
{
    public class Screening
    {
        private Movie movie;
        private int sequence;
        private DateTime whenScreened;

        public Money MovieFee
        {
            get
            {
                return movie.Fee;
            }
        }

        public DateTime StartTime
        {
            get
            {
                return whenScreened;
            }
        }

        public Screening(Movie movie, int sequence, DateTime whenScreened)
        {
            this.movie = movie;
            this.sequence = sequence;
            this.whenScreened = whenScreened;
        }

        public bool IsSequence(int sequence)
        {
            return this.sequence == sequence;
        }

        public Reservation reserve(Customer customer, int audienceCount)
		{
			// Requires : 사전 조건
			// Ensures : 사후 조건
            Contract.Requires(customer != null);
            Contract.Requires(audienceCount >= 1);
            Contract.Ensures(Contract.Result<Reservation>() != null);
			return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
		}

        private Money calculateFee(int count)
        {
            return movie.calculateMovieFee(this) * count;
        }

		// 불변식 : 인스턴스 생명 주기 전반에 걸쳐 지켜야 하는 규칙
		// - 생성자 실행 전, 생성자 실행 후, 메서드 실행 전, 메서드 실행 후에 호출된다.
		// - 메서드 실행 중에는 불변식을 만족할 필요가 없음
        [ContractInvariantMethod]
        private void Invariant() {
            Contract.Invariant(movie != null);
            Contract.Invariant(sequence >= 1);
            Contract.Invariant(whenScreened > DateTime.Now);
        }
	}
}
