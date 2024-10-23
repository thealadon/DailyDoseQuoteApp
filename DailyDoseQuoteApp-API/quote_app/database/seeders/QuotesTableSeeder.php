<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class QuotesTableSeeder extends Seeder
{
    public function run()
    {
        DB::table('quotes')->insert([
            // Finance quotes
            ['emotions' => 'Scared', 'category' => 'Finance', 'author' => 'Warren Buffett', 'quote' => 'Be fearful when others are greedy, and be greedy when others are fearful.'],
            ['emotions' => 'Scared', 'category' => 'Finance', 'author' => 'Cormac McCarthy', 'quote' => 'Scared in money can\'t win.'],
            ['emotions' => 'Scared', 'category' => 'Finance', 'author' => 'Franklin D. Roosevelt', 'quote' => 'The only thing we have to fear is fear itself.'],
            ['emotions' => 'Sad', 'category' => 'Finance', 'author' => 'Unknown', 'quote' => 'The saddest summary of life contains three descriptions: could have, might have, and should have.'],
            ['emotions' => 'Sad', 'category' => 'Finance', 'author' => 'Amelia Earhart', 'quote' => 'The most difficult thing is the decision to act, the rest is merely tenacity.'],
            ['emotions' => 'Sad', 'category' => 'Finance', 'author' => 'Michelangelo', 'quote' => 'The greatest danger for most of us is not that our aim is too high and we miss it, but that it is too low and we reach it.'],
            ['emotions' => 'Tired', 'category' => 'Finance', 'author' => 'Percy Bysshe Shelley', 'quote' => 'The rich get richer and the poor get poorer.'],
            ['emotions' => 'Tired', 'category' => 'Finance', 'author' => 'W.B. Yeats', 'quote' => 'The world is full of magic things, patiently waiting for our senses to grow sharper.'],
            ['emotions' => 'Tired', 'category' => 'Finance', 'author' => 'Marilyn Monroe & David Goggins', 'quote' => 'Don\'t stop when you\'re tired. Stop when you\'re done.'],
            ['emotions' => 'Anxious', 'category' => 'Finance', 'author' => 'Robert Kiyosaki', 'quote' => 'If you want to be financially free, you need to become a different person than you are today and let go of whatever has held you back in the past.'],
            ['emotions' => 'Anxious', 'category' => 'Finance', 'author' => 'Jen Sincero', 'quote' => 'Believe that you are worthy of financial freedom. Do something you love and then all you ever have to do is be yourself to succeed.'],
            ['emotions' => 'Anxious', 'category' => 'Finance', 'author' => 'Manoj Arora', 'quote' => 'To achieve what 1% of the world\'s population has (financial freedom), you must be willing to do what only 1% dare to do... hard work and perseverance of the highest order.'],
              // Relationship quotes
            ['emotions' => 'Scared', 'category' => 'Relationship', 'author' => 'Friedrich Nietzsche', 'quote' => 'The only way to overcome fear in relationships is to risk being vulnerable. It\'s in vulnerability that true connection grows.'],
            ['emotions' => 'Scared', 'category' => 'Relationship', 'author' => 'Mandy Hale', 'quote' => 'Don’t let the fear of losing someone stop you from giving your all to the relationship. Love is worth the risk.'],
            ['emotions' => 'Scared', 'category' => 'Relationship', 'author' => 'Mandy Hale', 'quote' => 'It is not the absence of fear that makes a relationship last; it\'s the courage to continue loving despite the fear.'],
            ['emotions' => 'Sad', 'category' => 'Relationship', 'author' => 'Psalm 147:3', 'quote' => 'He heals the brokenhearted and binds up their wounds.'],
            ['emotions' => 'Sad', 'category' => 'Relationship', 'author' => 'Jeremiah 29:11', 'quote' => 'For I know the plans I have for you," declares the Lord, "plans to prosper you and not to harm you, plans to give you hope and a future.'],
            ['emotions' => 'Sad', 'category' => 'Relationship', 'author' => 'Ecclesiastes 3:1', 'quote' => 'For everything there is a season, and a time for every matter under heaven.'],
            ['emotions' => 'Tired', 'category' => 'Relationship', 'author' => 'Unknown', 'quote' => 'A strong relationship requires choosing to love each other, even in those moments when you struggle to like each other.'],
            ['emotions' => 'Tired', 'category' => 'Relationship', 'author' => 'Unknown', 'quote' => 'Every relationship has its problems, but what makes it perfect is when you still want to be together despite the struggles.'],
            ['emotions' => 'Tired', 'category' => 'Relationship', 'author' => 'Unknown', 'quote' => 'Love is not about how much you say "I love you," but how much you prove that it\'s true, even when you\'re tired.'],
            ['emotions' => 'Anxious', 'category' => 'Relationship', 'author' => 'Astrid Alauda', 'quote' => 'Don\'t let your mind bully your body into believing it must carry the burden of its worries.'],
            ['emotions' => 'Anxious', 'category' => 'Relationship', 'author' => 'William James', 'quote' => 'The greatest weapon against stress is our ability to choose one thought over another.'],
            ['emotions' => 'Anxious', 'category' => 'Relationship', 'author' => 'Unknown', 'quote' => 'You can’t force someone to love you, but you can learn to love yourself. That’s where it all begins.'],
              // Education quotes
            ['emotions' => 'Scared', 'category' => 'Education', 'author' => 'William Butler Yeats', 'quote' => 'Education is not the filling of a pail, but the lighting of a fire.'],
            ['emotions' => 'Scared', 'category' => 'Education', 'author' => 'Walter Elliot', 'quote' => 'Perseverance is not a long race; it is many short races one after the other.'],
            ['emotions' => 'Scared', 'category' => 'Education', 'author' => 'Nelson Mandela', 'quote' => 'Education is the most powerful weapon which you can use to change the world.'],
            ['emotions' => 'Sad', 'category' => 'Education', 'author' => 'Carl Rogers', 'quote' => 'The only person who is educated is the one who has learned how to learn and change.'],
            ['emotions' => 'Sad', 'category' => 'Education', 'author' => 'Sir Ken Robinson', 'quote' => 'We are educating people out of their creative capacities.'],
            ['emotions' => 'Sad', 'category' => 'Education', 'author' => 'John Dewey', 'quote' => 'Education is a social process; education is growth; education is not a preparation for life but is life itself.'],
            ['emotions' => 'Tired', 'category' => 'Education', 'author' => 'Nelson Mandela', 'quote' => 'It always seems impossible until it\'s done.'],
            ['emotions' => 'Tired', 'category' => 'Education', 'author' => 'Albert Schweitzer', 'quote' => 'Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.'],
            ['emotions' => 'Tired', 'category' => 'Education', 'author' => 'John Dewey', 'quote' => 'Education is not preparation for life; education is life itself.'],
            ['emotions' => 'Anxious', 'category' => 'Education', 'author' => 'Lao Tzu', 'quote' => 'The journey of a thousand miles begins with one step.'],
            ['emotions' => 'Anxious', 'category' => 'Education', 'author' => 'Robert Collier', 'quote' => 'Success is the sum of small efforts, repeated day in and day out.'],
            ['emotions' => 'Anxious', 'category' => 'Education', 'author' => 'B.B. King', 'quote' => 'The beautiful thing about learning is that no one can take it away from you.'],
            // Work quotes
            ['emotions' => 'Scared', 'category' => 'Work', 'author' => 'Franklin D. Roosevelt', 'quote' => 'Do one thing every day that scares you.'],
            ['emotions' => 'Scared', 'category' => 'Work', 'author' => 'Anonymous', 'quote' => 'The greatest fear in the world is of the opinions of others. The moment you are unafraid of the crowd, you are no longer a sheep, you become a lion.'],
            ['emotions' => 'Scared', 'category' => 'Work', 'author' => 'Japanese Proverb', 'quote' => 'Fear is only as deep as the mind allows.'],
            ['emotions' => 'Sad', 'category' => 'Work', 'author' => 'Robin Williams', 'quote' => 'I used to think the worst thing in life was to end up all alone. It’s not. The worst thing in life is to end up with people that make you feel all alone.'],
            ['emotions' => 'Sad', 'category' => 'Work', 'author' => 'Arthur Golden', 'quote' => 'Adversity is like a strong wind. It tears away from us all but the things that cannot be torn, so that we see ourselves as we really are.'],
            ['emotions' => 'Sad', 'category' => 'Work', 'author' => 'Bill Gates', 'quote' => 'It\'s fine to celebrate success but it is more important to heed the lessons of failure.'],
            ['emotions' => 'Tired', 'category' => 'Work', 'author' => 'Confucius', 'quote' => 'It does not matter how slowly you go as long as you do not stop.'],
            ['emotions' => 'Tired', 'category' => 'Work', 'author' => 'Vince Lombardi', 'quote' => 'The price of success is hard work, dedication to the job at hand, and the determination that whether we win or lose, we have applied the best of ourselves to the task at hand.'],
            ['emotions' => 'Tired', 'category' => 'Work', 'author' => 'Anonymous', 'quote' => 'When you are tired, learn to rest, not quit.'],
            ['emotions' => 'Anxious', 'category' => 'Work', 'author' => 'Brian Tracy', 'quote' => 'Your ability to discipline yourself to set clear goals and then to work toward them every day will do more to guarantee your success than any other single factor.'],
            ['emotions' => 'Anxious', 'category' => 'Work', 'author' => 'Helen Keller', 'quote' => 'Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence.'],
            ['emotions' => 'Anxious', 'category' => 'Work', 'author' => 'Ralph Waldo Emerson', 'quote' => 'What lies behind us and what lies before us are tiny matters compared to what lies within us.'],
            // Friendship quotes
            ['emotionss' => 'Scared', 'category' => 'Friendship', 'author' => 'Mother Teresa', 'quote' => '“Some people come into our lives as blessings. Some come in your life as lessons.”'],
            ['emotionss' => 'Scared', 'category' => 'Friendship', 'author' => 'Unknown', 'quote' => '“Good friends are like stars. You don’t always see them, but you know they’re always there.”'],
            ['emotionss' => 'Scared', 'category' => 'Friendship', 'author' => 'Unknown', 'quote' => '“You can’t lose friends; if they are real friends, they will always come back.”'],
            ['emotionss' => 'Sad', 'category' => 'Friendship', 'author' => 'Elbert Hubbard', 'quote' => '“A friend is someone who knows all about you and still loves you.”'],
            ['emotionss' => 'Sad', 'category' => 'Friendship', 'author' => 'Unknown', 'quote' => '“Sometimes, being with your best friend is all the therapy you need.”'],
            ['emotionss' => 'Sad', 'category' => 'Friendship', 'author' => 'Ralph Waldo Emerson', 'quote' => '“The only way to have a friend is to be one.”'],
            ['emotionss' => 'Tired', 'category' => 'Friendship', 'author' => 'Unknown', 'quote' => '“Some friendships are like glass. They can be beautiful but are easily shattered.”'],
            ['emotionss' => 'Tired', 'category' => 'Friendship', 'author' => 'Marcus Tullius Cicero', 'quote' => '“Friendship improves happiness and abates misery, by the doubling of our joy and the dividing of our grief.”'],
            ['emotionss' => 'Tired', 'category' => 'Friendship', 'author' => 'Robert Southey', 'quote' => '“The loss of a friend is like that of a limb; time may heal the anguish of the wound, but the loss cannot be repaired.”'],
            ['emotionss' => 'Anxious', 'category' => 'Friendship', 'author' => 'Woodrow Wilson', 'quote' => '“Friendship is the only cement that will ever hold the world together.”'],
            ['emotionss' => 'Anxious', 'category' => 'Friendship', 'author' => 'Edna Buchanan', 'quote' => '“Friends are the family we choose for ourselves.”'],
            ['emotionss' => 'Anxious', 'category' => 'Friendship', 'author' => 'Unknown', 'quote' => '“Friendship is a contract of the heart, not of the mind.”'],
            // Family quotes
            ['emotionss' => 'Scared', 'category' => 'Family', 'author' => 'Desmond Tutu', 'quote' => '“You don’t choose your family. They are God’s gift to you, as you are to them.”'],
            ['emotionss' => 'Scared', 'category' => 'Family', 'author' => 'Unknown', 'quote' => '“To lose a family member is to lose a part of yourself.”'],
            ['emotionss' => 'Scared', 'category' => 'Family', 'author' => 'Unknown', 'quote' => '“In family life, love is the foundation, but fear of loss can make us appreciate it even more.”'],
            ['emotionss' => 'Sad', 'category' => 'Family', 'author' => 'George Santayana', 'quote' => '“The family is one of nature’s masterpieces.”'],
            ['emotionss' => 'Sad', 'category' => 'Family', 'author' => 'Unknown', 'quote' => '“Our family is a circle of strength and love. With every birth and every union, the circle grows.”'],
            ['emotionss' => 'Sad', 'category' => 'Family', 'author' => 'Unknown', 'quote' => '“Nothing is as important as family. It is the foundation of our lives.”'],
            ['emotionss' => 'Tired', 'category' => 'Family', 'author' => 'Friedrich Nietzsche', 'quote' => '“In family life, love is the oil that eases friction, the cement that binds closer together, and the music that brings harmony.”'],
            ['emotionss' => 'Tired', 'category' => 'Family', 'author' => 'Richard Bach', 'quote' => '“The bond that links your true family is not one of blood, but of respect and joy in each other’s life.”'],
            ['emotionss' => 'Tired', 'category' => 'Family', 'author' => 'Unknown', 'quote' => '“Family is a gift that lasts forever, but the fear of losing that gift can motivate us to hold on tightly.”'],
            ['emotionss' => 'Anxious', 'category' => 'Family', 'author' => 'Deuteronomy 5:16', 'quote' => '“Honor your father and mother, as the Lord your God has commanded you, so that you may live long and that it may go well with you in the land the Lord your God is giving you.”'],
            ['emotionss' => 'Anxious', 'category' => 'Family', 'author' => 'Psalm 147:3', 'quote' => '“He heals the brokenhearted and binds up their wounds.”'],
            ['emotionss' => 'Anxious', 'category' => 'Family', 'author' => 'Psalm 34:18', 'quote' => '“The Lord is close to the brokenhearted and saves those who are crushed in spirit.”'],            
        ]);
    }
}
